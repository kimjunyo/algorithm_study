import sys, math
n = int(input())
arr = list(map(int, input().split()))
# 오름차순으로 입력되므로 순서대로 좁혀가면서 구하면 됨
start = 0
end = n-1
INT_MAX = sys.maxsize
min_val = INT_MAX 
min_start = 0
min_end = n-1
while start < end:
  amount = arr[start]+arr[end]
  # min 값 초기화 하면서 간다.
  if abs(amount) <= abs(min_val):
    min_val = amount
    min_start = start
    min_end = end

  # 다음꺼로 넘어가기위해 처리법
  if amount ==0:
    break
    # 음수가 더크다는것이므로 더 노ㅓㅍ은값으로 간다.
  elif amount <= 0:
    start+=1
    # 양수가 더크다는것이므로 숫자를 더 낮은값
  else:
    end-=1

print(arr[min_start],arr[min_end])


# for idx,i in enumerate(arr):
#   for j in arr[idx+1:]:
#     if abs(i+j) <= min:
#       min = abs(i+j)
#       ans = [i, j]
# print(*ans)
