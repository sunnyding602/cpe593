function People(sthToSay){
    console.log(sthToSay);
}

People.call(this, "hello world");


function mod_pow(base, exponent, modulus){
    if(modulus == 1) return 0;
    var c = 1;
    for (var e_prime = 1; e_prime<=exponent; e_prime++){
        c = (c*base) % modulus;
    }
    return c;
}
//console.log(mod_pow(5, 64, 3483));

//97 
function is_prime(n, k){
    //step1  n-1 2^r*d
    var tmp = n-1;
    var r = 0; 
    while(true){
        if(tmp%2 == 0){
            tmp = tmp/2;
            r++;
        }else{
            break;
        }
    }

    var d = (n-1)/Math.pow(2, r)

    while(k-- > 0){
        var a = Math.floor((Math.random() * (n-2)) + 2);
        var x =  mod_pow(a, d, n);
        var enterWhileLoop = false;
        if( x == 1 || x == (n-1)) continue;
        for(var i =0; i<r-1; i++){
            x = x*x % n; 
            if(x == 1) return false;
            if(x == (n-1)) { enterWhileLoop = true; break};
        }
        if(enterWhileLoop) continue;
        return false;
    }
    return true;
}

console.log(is_prime(7923, 6));

