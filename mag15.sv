module mag15(
  input  logic [14:0] A,
  input  logic [14:0] B,
  output logic        AgtB,
  output logic        AeqB,
  output logic        AltB
);

  logic [14:0] gt_vec;
  logic [14:0] eq_vec;
  logic [14:0] lt_vec;

  // 15 instances, bit 0 = LSB gets the seed flags (0,1,0)
  cmp1bit iCMP[14:0](
    .A     (A),
    .B     (B),
    .AgtBi ({gt_vec[13:0], 1'b0}), // i=0 gets 0
    .AeqBi ({eq_vec[13:0], 1'b1}), // i=0 gets 1
    .AltBi ({lt_vec[13:0], 1'b0}), // i=0 gets 0
    .AgtBo (gt_vec),
    .AeqBo (eq_vec),
    .AltBo (lt_vec)
  );

  assign AgtB = gt_vec[14];
  assign AeqB = eq_vec[14];
  assign AltB = lt_vec[14];

endmodule
