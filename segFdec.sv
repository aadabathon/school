// note that this is NOT a program - it is a hardware description that gets turned into logic!

module segFdec
(
	input [3:0] D,
	output segF
);
logic n1, n0, t2, t3, t4, fon;
/// You figure out implementation as instances of verilog primitive gates ///

not (n1, D[1]);
not (n0, D[0]);

and (t2, n1, n0);       // ~D1 & ~D0
and (t3, D[2], n1);     // D2  & ~D1
and (t4, D[2], n0);     // D2  & ~D0

or  (fon, D[3], t2, t3, t4);
not (segF, fon);        // active-low output
endmodule

