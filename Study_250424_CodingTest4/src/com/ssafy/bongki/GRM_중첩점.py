# 입력 정사각형 크기 n, 반직선 m개 만큼 info list
n,m = map(int,input().split())
infoList = [list(map(str,input().split())) for _ in range(m)]

# 이제 반직선의 교차 점을 찾아야 하는데, RL UD랑은 평행해서 같은 지점에선 교차 안됨
# 그렇다면 직선이 있으면 그 직선에 응당 해당 하는 위치 값을 넣는 리스트를 입력해서 그 방문한 정보 값에 대해 비교해보면?
gridCol = [[0]*n for _ in range(n)] # grid 정보
gridRow = [[0]*n for _ in range(n)] # grid 정보

for info in infoList:
	x = int(info[0])-1
	y = int(info[1])-1
	dir = info[2]
	if dir == 'R':
		while (0<=y<n):
			gridRow[x][y] += 1
			y += 1
	if dir == 'L':
		while (0<=y<n):
			gridRow[x][y] += 1
			y -= 1
	if dir == 'U':
		while (0<=x<n):
			gridCol[x][y] += 1
			x -= 1
	if dir == 'D':
		while (0<=x<n):
			gridCol[x][y] += 1
			x += 1
# 정보 입력 완료
count = 0
# 이제 계산
for i in range(n):
	for j in range(n):
		count += gridCol[i][j]*gridRow[i][j]
print(count)
