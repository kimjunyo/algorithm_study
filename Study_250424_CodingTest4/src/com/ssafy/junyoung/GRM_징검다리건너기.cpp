#include <iostream>
#include <vector>
using namespace std;
int main() {
	int N;
	cin >> N;
	vector<int> input(N+2, 0);
	vector<int> res(N+2, 0);
	
	for(int i=1; i<=N; i++) {
		cin >> input[i];
	}
	
	for(int i=1; i<=N+1; i++) {
		int min = res[i-1] + input[i];
		if(i-2 >= 0 && min > res[i-2] + input[i]) {
			min = res[i-2] + input[i];
		}

		if(i-3 >= 0 && min > res[i-3] + input[i]) {
			min = res[i-3] + input[i];
		}
		res[i] = min;
	}
	
	cout << res[N+1] << endl;
	return 0;
}
