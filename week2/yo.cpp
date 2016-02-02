#include<iostream>
using namespace std;
int fab(int n){
    if(n<=5)
        return 4;
    return n * fab(n-2);
}
int main(int argc, const char * argv[]){
    for(auto i = 5; i< 100; i++){
        cout<<i<<" "<<fab(i)<<endl;
    }
}
