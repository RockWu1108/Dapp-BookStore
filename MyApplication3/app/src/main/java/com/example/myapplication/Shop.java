package com.example.myapplication;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class Shop extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550610cdc806100606000396000f3fe6080604052600436106100705760003560e01c8063780bd3f11161004e578063780bd3f11461012d578063c8691b2a146101ef578063da96832a146102aa578063fca56d401461038657610070565b80631aa3a0081461007557806322fdef941461008c57806353b62866146100f5575b600080fd5b34801561008157600080fd5b5061008a610468565b005b34801561009857600080fd5b506100db600480360360208110156100af57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061051e565b604051808215151515815260200191505060405180910390f35b61012b6004803603604081101561010b57600080fd5b81019080803590602001909291908035906020019092919050505061053e565b005b34801561013957600080fd5b506101666004803603602081101561015057600080fd5b81019080803590602001909291905050506107ee565b6040518080602001848152602001838152602001828103825285818151815260200191508051906020019080838360005b838110156101b2578082015181840152602081019050610197565b50505050905090810190601f1680156101df5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b3480156101fb57600080fd5b506102286004803603602081101561021257600080fd5b81019080803590602001909291905050506108b0565b6040518080602001838152602001828103825284818151815260200191508051906020019080838360005b8381101561026e578082015181840152602081019050610253565b50505050905090810190601f16801561029b5780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b3480156102b657600080fd5b50610384600480360360608110156102cd57600080fd5b8101908080359060200190929190803590602001906401000000008111156102f457600080fd5b82018360208201111561030657600080fd5b8035906020019184600183028401116401000000008311171561032857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929080359060200190929190505050610a00565b005b34801561039257600080fd5b506103df600480360360408110156103a957600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610b33565b6040518080602001848152602001838152602001828103825285818151815260200191508051906020019080838360005b8381101561042b578082015181840152602081019050610410565b50505050905090810190601f1680156104585780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b60001515600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515146104c557600080fd5b60018060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908315150217905550565b60016020528060005260406000206000915054906101000a900460ff1681565b60011515600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1615151461059b57600080fd5b3481600360008581526020019081526020016000206001015402146105bf57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc3073ffffffffffffffffffffffffffffffffffffffff16319081150290604051600060405180830381858888f1935050505015801561063d573d6000803e3d6000fd5b506040518060600160405280600360008581526020019081526020016000206000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106f35780601f106106c8576101008083540402835291602001916106f3565b820191906000526020600020905b8154815290600101906020018083116106d657829003601f168201915b5050505050815260200182600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000868152602001908152602001600020600101600082825401925050819055815260200142815250600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600084815260200190815260200160002060008201518160000190805190602001906107d2929190610c02565b5060208201518160010155604082015181600201559050505050565b6003602052806000526040600020600091509050806000018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561089a5780601f1061086f5761010080835404028352916020019161089a565b820191906000526020600020905b81548152906001019060200180831161087d57829003601f168201915b5050505050908060010154908060020154905083565b60606000600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000848152602001908152602001600020600001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600085815260200190815260200160002060010154818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109f05780601f106109c5576101008083540402835291602001916109f0565b820191906000526020600020905b8154815290600101906020018083116109d357829003601f168201915b5050505050915091509150915091565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610ac2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f596f7520617265206e6f74206f776e657200000000000000000000000000000081525060200191505060405180910390fd5b6040518060600160405280838152602001670de0b6b3a76400008302815260200142815250600360008581526020019081526020016000206000820151816000019080519060200190610b16929190610c02565b506020820151816001015560408201518160020155905050505050565b600260205281600052604060002060205280600052604060002060009150915050806000018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bec5780601f10610bc157610100808354040283529160200191610bec565b820191906000526020600020905b815481529060010190602001808311610bcf57829003601f168201915b5050505050908060010154908060020154905083565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610c4357805160ff1916838001178555610c71565b82800160010185558215610c71579182015b82811115610c70578251825591602001919060010190610c55565b5b509050610c7e9190610c82565b5090565b610ca491905b80821115610ca0576000816000905550600101610c88565b5090565b9056fea265627a7a72315820943fbe9543e4ac817e1d074a5e7ada2568f92fd97968ab7ce7471189f431c68e64736f6c634300050d0032";

    public static final String FUNC_BUYLIST = "buyList";

    public static final String FUNC_BUYPRODUCT = "buyProduct";

    public static final String FUNC_GETHISTORY = "getHistory";

    public static final String FUNC_ISREGISTER = "isRegister";

    public static final String FUNC_PRODUCT = "product";

    public static final String FUNC_REGISTER = "register";

    public static final String FUNC_SETPRODUCT = "setProduct";

    @Deprecated
    protected Shop(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Shop(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Shop(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Shop(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Tuple3<String, BigInteger, BigInteger>> buyList(String param0, BigInteger param1) {
        final Function function = new Function(FUNC_BUYLIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, BigInteger, BigInteger>>(function,
                new Callable<Tuple3<String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> buyProduct(BigInteger _ID, BigInteger _amount, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_BUYPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_ID), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<Tuple2<String, BigInteger>> getHistory(BigInteger _ID) {
        final Function function = new Function(FUNC_GETHISTORY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_ID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<String, BigInteger>>(function,
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Boolean> isRegister(String param0) {
        final Function function = new Function(FUNC_ISREGISTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Tuple3<String, BigInteger, BigInteger>> product(BigInteger param0) {
        final Function function = new Function(FUNC_PRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, BigInteger, BigInteger>>(function,
                new Callable<Tuple3<String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> register() {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setProduct(BigInteger _ID, String _name, BigInteger _price) {
        final Function function = new Function(
                FUNC_SETPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_ID), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.generated.Uint256(_price)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Shop load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Shop(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Shop load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Shop(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Shop load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Shop(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Shop load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Shop(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Shop> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Shop.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Shop> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Shop.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Shop> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Shop.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Shop> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Shop.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
