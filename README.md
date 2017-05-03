# Rule Engine
- Actionable Rules based on custom parameter.
- Based on infix expression evaluation.
- Extensible with simple DSL for new operator definition. 

 ### Sample Rule 
```json
{
  "lhs": "$price",
  "op" : "GTE",
  "rhs": "200"
}
```

### Complex Rule
```json
{
    "lhs": {
        "lhs": "$price",
        "op": "GTE",
        "rhs": "200"
    },
    "op": "AND",
    "rhs": {
        "lhs": "$inventory",
        "op": "GT",
        "rhs": "100"
    }
}
```

### JSON Rules 

```json
{
	"rule": {
		"lhs": "$price",
		"op": "GTE",
		"rhs": 1000
	},
	"action": {
		"result": {
			"lhs": "$price",
			"op": "DISCOUNT",
			"rhs": 10
		}
	}
}
```