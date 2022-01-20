import Client from "../models/client"
import Account from "../models/account"
import axios from 'axios';
import OperationReport from "../models/operationreport";

const TransactionService = {
    createClient,
    createAccount,
    updateAccount,
    getOperationReport
}

const backendsrc = "https://localhost:7113"

async function createClient(data: Client): Promise<any>{
    const url = `${backendsrc}/api/BankOps/client`;
    // Default options are marked with *
    console.log(data);
    return axios.post(url,data);
}

async function createAccount(data: Account): Promise<any>{
    const url = `${backendsrc}/api/BankOps/account`;
    // Default options are marked with *
    console.log(data);
    return axios.post(url,data);
}

async function updateAccount(data: Account): Promise<any>{
    const url = `${backendsrc}/api/BankOps/account/${data.accountid}`;
    // Default options are marked with *
    console.log(data);
    return axios.put(url,data);
}

async function getOperationReport(clientid: number, accountid: number): Promise<any>{
    const url = `${backendsrc}/api/BankOps/movements/${clientid}/${accountid}`;
    // Default options are marked with *
    return axios.get(url);
}

export default TransactionService;