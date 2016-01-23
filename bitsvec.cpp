#include <cstdint>
class Bitvec{
    private:
        unit64_t*bits;
        unit32_t*size;
        unit32_t*bitCount;
    public:
        Bitvec(unit32_t bits, bool v = false): size((bits+63)/64), bitCount(bits){
            bits = new unit64_t[size];
            if(v == true){
                for(int i=0; i<size; i++){
                    bits[i] = (unit64_t)-1LL;
                }
            }else{
                for(int i=0; i<size; i++){
                    bits[i] = 0;
                }
            }
        }

        void set(unit32_t i){
            bits[i/64]  |= (1<<i); //one left shift i
        }

        void clear(unit32_t i){
        
             bits[i / 64] &=~(1 <<i);
        }

        bool test(unit32_t i ){
            return bits[i/64] & (1<<i) != 0;
        
        }

        void setAll(){
            for(int i=0; i<size; i++){
                bits[i] = (unit64_t)-1LL;
            }
        }

};


