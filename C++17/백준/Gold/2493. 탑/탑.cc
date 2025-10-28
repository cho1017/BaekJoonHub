#include <iostream>
#include <stack>
using namespace std;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;  // 탑의 수 1~500,000
    cin >> N; 
    int tw; // 현재 노드(탑)
    int twArr[N];
    int resultArr[N];
    stack<int> twIdxStack;

    for (int i=0;i<N;i++){
        cin >> tw;
        twArr[i] = tw;
        //현재 노드보다 비교 노드가 작으면 
        //다음의 현재 노드에서 현재의 비교 노드와 수신할 일이 없으므로 
        //그 비교 노드의 정보를 삭제하여 연산을 줄인다 <- stack pop 
        if(i==0){
            twIdxStack.push(0);
            resultArr[0] = 0;
            continue;
        }
        while(!twIdxStack.empty()){
            int cprTwIdx = twIdxStack.top();
            //수신 성공
            if(twArr[cprTwIdx] >= tw){
                resultArr[i] = cprTwIdx+1;
                twIdxStack.push(i);
                break;
            }
            //비교 노드와 수신 실패
            else {
                twIdxStack.pop();
                //비교노드가 남아있지 않다면 수신 실패 처리 후 다음 노드 검사
                if(twIdxStack.empty()){
                    resultArr[i] = 0;
                    twIdxStack.push(i);
                    break;
                }
            }
        }
    }
    for(int i = 0; i<N;i++){
        cout << resultArr[i] << ' ';
    }
    return 0;
}