# RPN Logic Parser
<img align="center" width="600" src="https://user-images.githubusercontent.com/45922387/163029385-d58cb206-4406-464a-9514-f2313a2c6b32.png">
Truth table generator and evaulator for logical expressions in Java, using a few design patterns taught in my OOP module.
Data validation is used to avoid runtime errors.

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
