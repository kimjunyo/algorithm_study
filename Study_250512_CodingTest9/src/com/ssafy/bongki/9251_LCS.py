import sys
input = sys.stdin.readline

str1 = str(input().strip())
str2 = str(input().strip())

#LCS는 무조건 이중DP

def lcs(x,y):
  m,n = len(x),len(y)
  dp= [[0]*(n+1) for _ in range(m+1)]
  for i in range(1,m+1):
    for j in range(1,n+1):
      #약간 인접리스트로 한문자에대해서 다른 문자의 하나하나 같은 지 개수를 구하고 최종 초기화를 함
      if x[i-1]== y[j-1]: # 수열 순서에 대해서 해당 부분이 같으면 연속되므로 하나씩 넣고
        dp[i][j] = dp[i-1][j-1]+1
      else: #안같으면 그 이전값중에 큰값을 받아와서 다음꺼랑 다시 비교
        dp[i][j]= max(dp[i-1][j],dp[i][j-1])
    # print(dp)
  return dp[m][n]

print(lcs(str1,str2))
