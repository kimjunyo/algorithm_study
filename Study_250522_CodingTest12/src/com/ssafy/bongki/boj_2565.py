import sys
input = sys.stdin.readline
n = int(input())
wire = [tuple(map(int,input().split())) for _ in range(n)]
wire.sort() # A 전봇대 기준으로 정렬 필수

# 1로 초기화 => 자기 자신의 원소를 의미하는 1
dp = [1]*n

# LIS
for i in range(1,n): # A 전봇대의 번호 i
    for j in range(i): # A 전봇대의 번호 j (i보다 이전에 있는 번호들)
    	# 만약 나중 번호인 i의 B 전봇대 연결 번호가 이전 번호인 j의 B 전봇대 연결 번호보다 크면,
        # 현재 A 전봇대의 i 번째까지의 번호들과 교차 없이 연결 가능한 전깃줄 개수가 담긴 dp[i]를 
        # dp[j]까지의 최대 전깃줄 개수에 1을 더한 수와 비교하여 더 큰 수로 갱신해준다.
        if wire[j][1] < wire[i][1]:
            dp[i] = max(dp[i],dp[j]+1)

# 전체 개수에서 최장 증가 수열 개수를 빼주면 된다.
print(n - max(dp))
