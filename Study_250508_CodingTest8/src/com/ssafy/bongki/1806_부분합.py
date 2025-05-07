import sys

def main():
    input = sys.stdin.readline
    n, s = map(int, input().split())
    nums = list(map(int, input().split()))

    INF = n + 1
    left = cur = 0
    ans = INF
    for right, val in enumerate(nums):
        cur += val
        while cur >= s:
            ans = min(ans, right - left + 1)
            cur -= nums[left]
            left += 1
    print(0 if ans == INF else ans)

if __name__ == "__main__":
    main()
