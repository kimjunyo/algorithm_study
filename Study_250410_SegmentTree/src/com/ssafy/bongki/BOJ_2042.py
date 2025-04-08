n,m,k = map(int,input().split())
# m은 수의 변경 n은 수 k는 구한합 횟수
nums = [int(input()) for _ in range(n)]
# seg_tree[1] : 모든 노드의 합
# seg_tree[2] : 0~n//2번 노드의 합
# seg_tree[3] : n//2+1~n번 노드의 합

seg_tree = [0 for _ in range(n*4)] # 미리트리크기 확장 어차피 포화이진트리로 만들어야하므로

def build_tree(x,left,right):
    if left == right:
        seg_tree[x] == num[left]
        return seg_tree[x]
    mid = (left+right)//2
    left_value = build_tree(2*x,left,mid)
    right_value = build_tree(2*x+1,mid+1,right)
    seg_tree[x] = left_value+right_value
    return seg_tree[x]

build_tree(1,0,n-1)

def find_tree(b,c,x,left,right):
    # 구하고 싶은 구간(b~c)가 현재 트리 구간에 포함 X
    if c < left or right < b:
        return 0
    # 구하고 싶은 구간(b~c) 안에 현재 트리 포함
    if b <= left and right <= c:
        return seg_tree[x]
    mid = (left+right)//2
    left_value = find_tree(b,c,x*2,left,mid)
    right_value = find_tree(b,c,x*2+1,mid+1,right)
    return left_value + right_value

def update_tree(x,left,right,idx,val):
    if left == right == idx:
        seg_tree[x] = val
        return
    # 현재 구간에 idx가 포함 X
    if idx < left or right < idx:
        return

    mid = (left + right) // 2
    update_tree(x * 2, left, mid, idx, val)
    update_tree(x * 2 + 1, mid + 1, right, idx, val)

    seg_tree[x] = seg_tree[x * 2] + seg_tree[x * 2 + 1]


for _ in range(m + k):
    a, b, c = map(int, input().split())
    # a=1일때 b번째 수를 c로 바꾸기
    if a == 1:
        update_tree(1, 0, n - 1, b - 1, c)
    # a=2일때 b번째 수부터 c번째 수까지 합 구하기
    else:
        s = find_tree(b - 1, c - 1, 1, 0, n - 1)
        print(s)
