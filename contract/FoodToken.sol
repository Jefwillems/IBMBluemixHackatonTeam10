pragma solidity ^0.4.15;

contract Owned {
    address public owner;

    modifier isOwner(address check){
        require(check == owner);
        _;
    }
}

contract FoodToken is Owned {
    // Balances for each account
    mapping(address => uint256) public balances;
   
    string public name;
    string public symbol;

    //constructor
    function FoodToken(string _name, string _symbol) public {
         owner = msg.sender;
         name = _name;
         symbol = _symbol;
    }
 
    function balanceOf(address _owner) public constant returns (uint256 balance) {
         return balances[_owner];
    }
  
    function transfer(address _to, uint256 _amount) public returns (bool success) {
         if (balances[msg.sender] >= _amount 
            && _amount > 0
            && balances[_to] + _amount > balances[_to]) {
            balances[msg.sender] -= _amount;
            balances[_to] += _amount;
            return true;
        } else {
            return false;
        }
    }
  
    function transferFrom(
        address _from,
        address _to,
        uint256 _amount
    ) public returns (bool success) {
        if (balances[_from] >= _amount
             && _amount > 0
             && balances[_to] + _amount > balances[_to]) {
             balances[_from] -= _amount;
             balances[_to] += _amount;
             return true;
        } else {
             return false;
        }
    }

    function mintToken(address _to, uint256 _amount) public isOwner(msg.sender) returns (bool success) {
        if (balances[_to] + _amount > balances[_to]
            && _amount > 0) {
            balances[_to] += _amount;
            return true;
        }else {
            return false;
        }
    }
}