interface OperationReport {
    operationID: number,
    clientID: number,
    accountID: number,
    fullName: string,
    transaction: string,
    amount: number,
    createdAt: string,
};

export default OperationReport;