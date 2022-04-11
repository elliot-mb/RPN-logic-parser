# RPN Logic Parser
Truth table generator and evaulator for logical expressions in Java.\
Using a few design patterns taught in my degree course. 
https://cdn.discordapp.com/attachments/214715640928403456/963179095338922104/unknown.png
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
