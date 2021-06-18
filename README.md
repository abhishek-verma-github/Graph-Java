# Graph
**A basic Graph implementation with couple of frequent algorithms implementation.**

It has a node class which has an identifier, a value of generic type T {generally we use Numeric value},
defined as: `VertexNode<T>`, where T is Type for value.
`String identifier` for node identification, and other basic fields related with usual graph operation.

Graph is implemented using **adjancency list** representation.

Class `Graph` has `vertices` list for carrying list of vertices,
an dict of `edges` of type `{'vertex1':[adjacent-vertices-list],'verex2'}:[adjacenct-vertices-list, ... ]`, a dict of weights `{(from_edge,to_edge):weight, (from_edge,to_edge):weight, ...}` here tuple `(from_edge,to_edge)`
is implemented with a class `Weight<T,S>` where T and S both are `String` type (identifiers) and a _HashTable_ for Vertex lookup `vertices_hashmap`.

