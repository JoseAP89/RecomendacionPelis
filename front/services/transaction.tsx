import axios from 'axios';
import Genero from '../models/dupla';

const TransactionService = {
    getGeneros,
    getPersonas
}

const backendsrc = "http://localhost:8080"

/*
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
*/
async function getGeneros(): Promise<any>{
    const url = `${backendsrc}/api/generos`;
    // Default options are marked with *
    return axios.get(url);
}

async function getPersonas(persona: string): Promise<any>{
    const url = `${backendsrc}/api/personas`;
    // Default options are marked with *
    return axios.get(url, {params:{name:persona}});
}

export default TransactionService;