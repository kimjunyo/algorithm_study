import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

#(x,y)에서 3가지의 파이프 방향이 잡힌다고 보면, 2차원dp에 방향값까지 포함시키기 
dp = [[[0]*3 for _ in range(n)] for _ in range(n)]

# init (0,1) -> 시작 좌표에 파이프가 가로 방향으로 무조건 존재하고 이를 회전하거나 움직이므로
dp[0][1][0] = 1

for i in range(n):
  for j in range(2,n): #1부터이므로 2
    if arr[i][j] == 1: #벽이므로 무시
      continue

    # 가로로 가면, 0과 2일떄의 방향만 가능
    if arr[i][j-1]==0:
      dp[i][j][0] += dp[i][j-1][0]+dp[i][j-1][2]

    # 세로로 가면, 1과 2일떄의 방향만 가능
    if i >0 and arr[i-1][j]==0:
      dp[i][j][1] += dp[i-1][j][1]+dp[i-1][j][2]

    # 대각선?
    if i>0 and arr[i-1][j] == 0 and arr[i][j-1] == 0 and arr[i-1][j-1] == 0:
      dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1]+dp[i-1][j-1][2]  

print(sum(dp[n-1][n-1]))
