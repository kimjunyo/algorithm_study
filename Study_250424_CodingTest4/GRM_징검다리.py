n = int(input())
arr = list(map(int,input().split()))
dp = [0 for _ in range(n)]

for i in range(3):
	dp[i] = arr[i]
for i in range(3,n):
	dp[i] = min(min(dp[i-1],dp[i-2]),dp[i-3]) + arr[i]

if n>=3:
	print(min(min(dp[-1],dp[-2]),dp[-3]))
else:
	print(0)
