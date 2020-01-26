pragma solidity 0.5.0;

contract shop{
    
    address payable owner;
    
    struct ProductInfo{
        string name;
        uint price;
        uint time;
    }
    
    struct List{
        string productName;
        uint amount;
        uint buyTime;
    }
    
    modifier onlyOwner{
        require(msg.sender == owner,"You are not owner");
        _;
    }
    
    modifier isMember{
        require(isRegister[msg.sender] == true);
        _;
    }
    mapping (address => bool) public isRegister;
    mapping (address => mapping (uint => List) ) public buyList;
    mapping (uint => ProductInfo) public product;
    
    
    struct History{
        uint[] productID;
        string[] productName;
        mapping (uint => uint) amount;
    }
    mapping (address => History) basket;
    
    constructor()public{
        owner = msg.sender;
    }
    
    function register() public{
        require(isRegister[msg.sender] == false);
        isRegister[msg.sender] = true;
    }
    
    function setProduct(uint _ID, string memory _name, uint _price) 
    onlyOwner public{
        product[_ID] = ProductInfo({
            name : _name,
            price : _price * 1 ether,
            time : now
        });
    }
    
    function buyProduct(uint _ID, uint _amount) payable isMember public{
        require(product[_ID].price * _amount == msg.value);
        // owner.transfer(msg.value);
        owner.transfer(address(this).balance);
        buyList[msg.sender][_ID] =List({
            productName : product[_ID].name,
            amount : buyList[msg.sender][_ID].amount += _amount,
            buyTime : now
        });
    }
    
    function getHistory(uint _ID) view public 
    returns(string memory, uint){
        return (
            buyList[msg.sender][_ID].productName,
            buyList[msg.sender][_ID].amount);
    } 
}