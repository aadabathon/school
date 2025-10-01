module cmp1bit(
  input 	A,				// incoming A-bit to compare
  input 	B,				// incoming B-bit to compare
  input 	AgtBi,			// bit below was greater
  input		AeqBi,			// bit below was equal
  input		AltBi,			// bit below was less
  output 	AgtBo,			// outgoing compare result
  output	AeqBo,			// outgoing compare result
  output	AltBo			// outgoing compare resul
);

logic nA, nB, AxorB, AeqB_local, Agt_local, Alt_local;
logic gt_pass, lt_pass;



not n0(nA, A);
not n1(nB, B);

and n2(Agt_local, A, nB);

and n3(Alt_local, nA, B);


xnor n4(AeqB_local, A, B);

and n5(gt_pass, AeqB_local, AgtBi);
and n6(lt_pass, AeqB_local, AltBi);

and n7(AeqBo, AeqB_local, AeqBi);

or  n8(AgtBo, Agt_local, gt_pass);
or  n9(AltBo, Alt_local, lt_pass);


  //////////////////////////////////////////
  // Declare any needed internal signals //
  ////////////////////////////////////////

  
  //////////////////////////////////////////////
  // Implement cmp1bit logic as structural   //
  // (placement of primitive gates) verilog //
  ///////////////////////////////////////////


endmodule  

