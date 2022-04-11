# RPN Logic Parser
Truth table generator and evaulator for logical expressions in Java.\
Using a few design patterns taught in my degree course. 
Data validation is used to avoid runtime errors.
![image](https://user-images.githubusercontent.com/45922387/162830507-24bcae5e-4e58-4b48-bbb2-6f4764360130.png)
## Usage notes 
Variables:
- any meaningless string (e.g. A, b, myTruthValue)

Nullary operators (constants):
- ``F``, ``0`` (false)
- ``T``, ``1`` (true)

Unary operators:
- ``¬``, ``!`` (not)
- ``#`` (no-op)

Binary operators:
- ``n`` (and), ``!n`` (nand)
- ``v`` (or), ``!v`` (nor), ``xv`` (xor)
- ``=>`` (implies), ``<>`` (biconditional)
