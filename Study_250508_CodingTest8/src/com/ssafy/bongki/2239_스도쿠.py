import sys

input = sys.stdin.readline
board = [list(map(int, input().strip())) for _ in range(9)]

row = [0]*9      # i번째 행에 사용된 숫자 비트
col = [0]*9      # j번째 열
box = [0]*9      # 3x3 박스(0~8)

blanks = []
for i in range(9):
    for j in range(9):
        v = board[i][j]
        if v:
            bit = 1 << v
            row[i] |= bit
            col[j] |= bit
            box[(i//3)*3 + j//3] |= bit
        else:
            blanks.append((i, j))

def dfs(idx=0):
    if idx == len(blanks):
        # 모두 채움 -> 출력 후 종료
        print("\n".join("".join(map(str, row_)) for row_ in board))
        sys.exit(0)

    # 가능 숫자 수 최소ㄹ 선택
    min_idx, min_cand = -1, 10
    for k in range(idx, len(blanks)):
        i, j = blanks[k]
        mask = row[i] | col[j] | box[(i//3)*3 + j//3]
        cand_cnt = 9 - bin(mask).count("1")
        if cand_cnt < min_cand:
            min_cand, min_idx = cand_cnt, k
            if cand_cnt == 1:
                break
    blanks[idx], blanks[min_idx] = blanks[min_idx], blanks[idx]
    i, j = blanks[idx]

    mask = row[i] | col[j] | box[(i//3)*3 + j//3]
    for num in range(1, 10):
        bit = 1 << num
        if not (mask & bit):
            board[i][j] = num
            row[i] |= bit
            col[j] |= bit
            box[(i//3)*3 + j//3] |= bit

            dfs(idx + 1)

            # backtrack
            board[i][j] = 0
            row[i] &= ~bit
            col[j] &= ~bit
            box[(i//3)*3 + j//3] &= ~bit

dfs()
