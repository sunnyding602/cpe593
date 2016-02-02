#include<iostream>
#include<fstream>
using namespace std;


void match(int x[], int parent, int n){
    int left = 2*parent + 1;
    int right = 2*parent + 2;
    if(left >= n){
        return; 
    }
    if(right >= n){//this means left one is good
        if(x[left]  > x[parent]){
            swap(x[left], x[parent]);
            match(x, left, n);
        }
    }

    if(x[left] > x[right]){
        if(x[left]  > x[parent]){
            swap(x[left], x[parent]);
            match(x, left, n);
        }
    }else{
    
    }

}
void makeHeap(int x[], int n){
    for(int i = n/2; i>=0; i--){
        match(x, i, n);
    
    }
}

void reformHeap(int x[], int n){
    swap(x[0], x[n]);
    match(x, 0, n);

}
void heapsort(int x[], int n){
    makeheap(x, n);
    for(int i = n/2; i>= 0; i--){
        reformHeap(x, n--);
    }
}
int main(){
    ifstream f("hw3.dat");
    int n;
    f >> n;
    int x[n];
    for(int i = 0; i<n; i++){
        f >> x[i];
    }

    heapsort(x, n);
    return 0;
}
