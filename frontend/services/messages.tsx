import { Alert, AlertIcon, Heading } from '@chakra-ui/react'
import { useEffect, useState } from 'react';

const MessageService = {
    OkMessage,
    ErrorMessage
}


function OkMessage(msg: string, time: number = 5){
    const [showMsg, setShowMsg] = useState<boolean>(true);
    useEffect(() => {
        setTimeout(() => {
           setShowMsg(true); 
        }, 1000 * time);
    }, [])

    return (
        <Alert status='success' hidden={!showMsg}>
        <AlertIcon />
        {msg}
        </Alert>

    )
}

function ErrorMessage(msg: string, time: number = 5){
    const [showMsg, setShowMsg] = useState<boolean>(true);
    useEffect(() => {
        setTimeout(() => {
           setShowMsg(true); 
        }, 1000 * time);
    }, [])
    return (
        <Alert status='error' hidden={!showMsg}>
        <AlertIcon />
        {msg}
        </Alert>

    )
}

export default MessageService;