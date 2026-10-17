import cv2
import numpy as np

VIDEO_PATH = "fractal.webm"
OUTPUT_TXT = "video_frames.txt"
WIDTH = 80
ROWS = 24
TARGET_FPS = 15

# --- Ajustes de brilho/contraste ---
LOW_PCT = 5          # percentil que vira "preto" (sobe = fundo mais limpo)
HIGH_PCT = 99.5      # percentil que vira "branco" (desce = mais brilho geral)
GAMMA = 0.8          # <1 clareia, >1 escurece os tons médios
CENTER_BOOST = 0.8   # 0 = desligado; 1 = centro até 2x mais brilhante
CENTER_SIZE = 0.35   # tamanho da região central (0.2 = pequena, 0.6 = grande)
PER_FRAME = False    # True = auto-contraste por frame (pode piscar)

CHARS = np.array(list(" .:-=+*#%@"))   # escuro -> claro

cap = cv2.VideoCapture(VIDEO_PATH)
if not cap.isOpened():
    raise SystemExit("Não consegui abrir o vídeo")

src_fps = cap.get(cv2.CAP_PROP_FPS) or 30
step = max(1, round(src_fps / TARGET_FPS)) if TARGET_FPS else 1

def to_small(frame):
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    return cv2.resize(gray, (WIDTH, ROWS), interpolation=cv2.INTER_AREA).astype(np.float32)

# 1) Primeira passada: calcula os níveis globais (evita piscar entre frames)
frames = []
i = 0
while True:
    ret, frame = cap.read()
    if not ret:
        break
    if i % step == 0:
        frames.append(to_small(frame))
    i += 1
cap.release()

allpix = np.concatenate([f.ravel() for f in frames])
g_lo, g_hi = np.percentile(allpix, [LOW_PCT, HIGH_PCT])
print(f"Níveis globais: preto={g_lo:.1f} branco={g_hi:.1f}")

# Máscara radial (gaussiana) para destacar o centro
yy, xx = np.mgrid[0:ROWS, 0:WIDTH]
cy, cx = (ROWS - 1) / 2, (WIDTH - 1) / 2
d2 = ((yy - cy) / (ROWS * CENTER_SIZE)) ** 2 + ((xx - cx) / (WIDTH * CENTER_SIZE)) ** 2
center_gain = 1.0 + CENTER_BOOST * np.exp(-d2)

# 2) Segunda passada: converte para ASCII
with open(OUTPUT_TXT, "w", encoding="ascii", newline="\n") as f:
    for small in frames:
        lo, hi = (np.percentile(small, [LOW_PCT, HIGH_PCT]) if PER_FRAME else (g_lo, g_hi))
        norm = np.clip((small - lo) / max(hi - lo, 1e-6), 0, 1)
        norm = norm ** GAMMA
        norm = np.clip(norm * center_gain, 0, 1)
        idx = (norm * (len(CHARS) - 1)).round().astype(int)
        f.write("\n".join("".join(r) for r in CHARS[idx]) + "\n")

frame_bytes = WIDTH * ROWS + ROWS
print(f"{len(frames)} frames | {frame_bytes} bytes por frame | total {len(frames) * frame_bytes} bytes")