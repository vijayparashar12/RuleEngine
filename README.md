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

every rule evaluation return boolean result. 

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

DSL allows custom operators to be included in rule engine based on requirements. 

### Actionable Rules 

If a rule is evaluated to be true then action is preformes , other wise execution of the action is skiped. 

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
