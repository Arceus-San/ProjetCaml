(* Instructions of the CAM *)

open Miniml;;

type instr =
  PrimInstr of primop
| Cons
| Push
| Swap
| Return
| Quote of value
| Cur of code
| App
| Branch of code * code
(* new for recursive calls *)
| Call of var
| AddDefs of (var * code) list
| RmDefs of int
and value =
  NullV 
| VarV of Miniml.var
| IntV of int
| BoolV of bool
| PairV of value * value
| ClosureV of code * value
and code = instr list
  
type stackelem = Val of value | Cod of code

let rec exec = function
	(PairV(x,y),PrimInstr(UnOp(Fst))::c,st)->exec(x,c,st)
	|(PairV(x,y),PrimInstr(UnOp(Snd))::c,st)->exec(y,c,st)
	|(x,Cons::c,(Val y)::st)->exec(PairV(y,x),c,st)
	|(x,Push::c,st)->exec(x,c,(Val x)::st)
	|(x,Swap::c,(Val y)::st)->exec(y,c,(Val x)::st)
	|(t,(Quote v)::c,st)->exec(v,c,st)
	|(PairV(ClosureV(x,y),z),App::c,st)->exec(PairV(y,z),x,(Cod c)::st)
	|(BoolV b,(Branch(c1,c2))::c,(Val x)::st)->exec(x,(if b then c1 else c2),(Cod c)::st)

	|(PairV(IntV m,IntV n),PrimInstr(BinOp(BArith(BAadd)))::c,st)->exec(IntV(m+n),c,st)
	|(PairV(IntV m,IntV n),PrimInstr(BinOp(BArith(BAsub)))::c,st)->exec(IntV(m-n),c,st)
	|(PairV(IntV m,IntV n),PrimInstr(BinOp(BArith(BAmul)))::c,st)->exec(IntV(m*n),c,st)
	|(PairV(IntV m,IntV n),PrimInstr(BinOp(BArith(BAdiv)))::c,st)->exec(IntV(m/n),c,st)
	|(PairV(IntV m,IntV n),PrimInstr(BinOp(BArith(BAmod)))::c,st)->exec(IntV(m mod n),c,st)

	|(PairV(IntV m,IntV n),PrimInstr(BinOp(BCompar(BCeq)))::c,st)->exec(BoolV(m = n),c,st)
	|(PairV(IntV m,IntV n),PrimInstr(BinOp(BCompar(BCge)))::c,st)->exec(BoolV(m >= n),c,st)
	|(PairV(IntV m,IntV n),PrimInstr(BinOp(BCompar(BCgt)))::c,st)->exec(BoolV(m > n),c,st)
	|(PairV(IntV m,IntV n),PrimInstr(BinOp(BCompar(BCle)))::c,st)->exec(BoolV(m <= n),c,st)
	|(PairV(IntV m,IntV n),PrimInstr(BinOp(BCompar(BClt)))::c,st)->exec(BoolV(m < n),c,st)
	|(PairV(IntV m,IntV n),PrimInstr(BinOp(BCompar(BCne)))::c,st)->exec(BoolV(m <> n),c,st)

	|(x,(Cur c1)::c,st)->exec(ClosureV(c1,x),c,st)
	|(x,Return::c,(Cod c1)::st)->exec(x,c1,st)
	|cfg->cfg;;
