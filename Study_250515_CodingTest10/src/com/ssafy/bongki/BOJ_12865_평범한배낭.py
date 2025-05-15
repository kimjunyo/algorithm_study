
import sys
input = sys.stdin.readline
#n개 물건과 k개의 최대무게 배낭
n, k = map(int, input().split())
items = []

#각물건의 무게와 해피정도 v
for _ in range(n):
    w, v = map(int, input().split())
    items.append((w, v))

#k무게까지의 행복정도 미리 최대크기
dp =[0]*(1000001)
  
for i in range(1,k+1):
  dp[i] = dp[i-1] + weight[i]
