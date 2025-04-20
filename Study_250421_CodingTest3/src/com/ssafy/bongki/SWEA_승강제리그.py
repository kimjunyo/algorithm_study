class UserSolution:
    def __init__(self):
        self.N = 0
        self.L = 0
        self.leagues = []

    def init(self, N, L, mAbility):
        self.N = N
        self.L = L
        self.M = N // L
        self.leagues = [[] for _ in range(L)]
        for i in range(N):
            ability = mAbility[i]
            league_id = i // self.M
            self.leagues[league_id].append((ability, i))

    def move(self):
        moved = []
        sorted_leagues = [sorted(league, key=lambda x: (-x[0], x[1])) for league in self.leagues]

        ups = [None] * self.L
        downs = [None] * self.L

        for i in range(self.L):
            if i > 0:
                ups[i] = sorted_leagues[i][0]
            if i < self.L - 1:
                downs[i] = sorted_leagues[i][-1]

        for i in range(self.L):
            if ups[i]:
                self.leagues[i].remove(ups[i])
                self.leagues[i - 1].append(ups[i])
                moved.append(ups[i][1])
            if downs[i]:
                self.leagues[i].remove(downs[i])
                self.leagues[i + 1].append(downs[i])
                moved.append(downs[i][1])

        return sum(moved)

    def trade(self):
        moved = []
        sorted_leagues = [sorted(league, key=lambda x: (-x[0], x[1])) for league in self.leagues]

        for i in range(1, self.L):
            top = sorted_leagues[i][0]

            upper_league_sorted = sorted_leagues[i - 1]
            mid_index = (len(upper_league_sorted) + 1) // 2 - 1
            mid = upper_league_sorted[mid_index]

            # 실제 league에서도 remove
            self.leagues[i].remove(top)
            self.leagues[i - 1].remove(mid)

            # swap
            self.leagues[i].append(mid)
            self.leagues[i - 1].append(top)

            moved.extend([top[1], mid[1]])

        return sum(moved)
