#include <iostream>
#include <vector>

using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, -1, 0, 1};
int N, M;

int main() {
	
	cin >> N >> M;
	vector<vector<vector<int>>> input(N, vector<vector<int>>(N, vector<int>(2, 0)));
	for(int i=0; i<M; i++) {
		int a, b;
		char dir;
		cin >> a >> b >> dir;
		
		int direction;
		switch(dir) {
			case 'U':
				direction = 0;
				break;
			case 'L':
				direction = 1;
				break;
			case 'D':
				direction = 2;
				break;
			case 'R':
				direction = 3;
				break;
		}
		int nr, nc;
		for(int j=0; j<N; j++) {
			nr = a-1 + dr[direction] * j;
			nc = b-1 + dc[direction] * j;
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			input[nr][nc][direction%2]++;
		}
	}
	long sumTotal = 0;
	for(int i=0; i<N; i++) {
		for(int j=0; j<N; j++) {

			long sum = 1;
			for(int k=0; k<2; k++) {
					sum *= input[i][j][k];
			}
			sumTotal += sum;
		}
	}
	
	cout << sumTotal << endl;
	return 0;
}
