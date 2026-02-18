## Decision Table Testing

Black-box testing technique based on tabulating all conditions and the corresponding expected action 
 - A full table contains every feasible combination of conditions. 
 - Rows delineate independent and dependent variables while columns delineate a unique combination of them. 
 - Values may be boolean values (T/F) or a range of inputs/outputs. Coverage is defined by the number of columns tested out of the total number number of columns.
 - Coverage is measured by ratio of tested columns columns to total columns.

### Decision Table Simplification

 - Decision tables grow exponentially based on the number of variables. Therefore, it's important to simplify them.
 - Basic simplification of tables such as eliminating impossible cases or merging columns
 - Boolean algebra and other techniques such as k-maps can do more heavy lifting.