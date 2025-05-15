import sys
input = sys.stdin.readline
N, K = map(int, input().split())
bag = [list(map(int, input().split())) for _ in range(N)]
dp = [[0]*(K+1) for _ in range(N+1)]
#k무게까지의 행복정도 미리 최대크기


for i in range(1,N+1): # 물건들 찾기
  for j in range(1,K+1): # 최대무게까지의 순서
    if j>= bag[i-1][0]: #현재 최대 무게인 j가 가방의 지금 물건무게보다 큰경우    
      dp[i][j] = max(bag[i-1][1] + dp[i-1][j-bag[i-1][0]],dp[i-1][j])
      # 이전 물건의 해피와 현재까지의 물건의 happy 들의 최댓값 ,, 최댓값 가방해피를 더해비교해서 선택
    else:
      #현재최대무게j가 해당물건무게보다 작은 경우 (현재 물건을 담을 수 없는 경우 넘어감)
      dp[i][j] = dp[i-1][j]
print(dp[N][K])
