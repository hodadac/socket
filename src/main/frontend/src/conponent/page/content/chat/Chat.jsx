import { useRef, useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import * as StompJs from '@stomp/stompjs';

function CreateReadChat() {
    const [chatList, setChatList] = useState([]);
    const [chat, setChat] = useState('');

    const apply_id  = localStorage.getItem('member');
    const client = useRef({});

    const connect = () => {
        client.current = new StompJs.Client({
            brokerURL: 'ws://localhost:8080/ws',
            onConnect: () => {
                console.log('success');
                subscribe();
            },
        });
        client.current.activate();
    };

    const publish = (chat) => {
        console.log("publish:",chat)
        if (!client.current.connected){
            return;
        }
        console.log(apply_id)
        const message = {
            channelId: 1,
            writerId: Number(apply_id),
            chat: chat,
        }
        console.log(message)
        client.current.publish({
            destination: '/pub/chat',
            body: JSON.stringify(message),
        });

        setChat('');
    };

    const subscribe = () => {
        client.current.subscribe('/sub/chat', (body) => {
            const json_body = JSON.stringify(body.body);
            setChatList((_chat_list) => [
                ..._chat_list, json_body
            ]);
        });
    };

    const disconnect = () => {
        client.current.deactivate();
    };


    const handleChange = (event) => { // 채팅 입력 시 state에 값 설정
        setChat(event.target.value);
    };

    const handleSubmit = (event, chat) => { // 보내기 버튼 눌렀을 때 publish
        event.preventDefault();
        console.log(chat)
        publish(chat);
    };

    useEffect(() => {
        connect();

        return () => disconnect();
    }, []);

    return (
        <div>
            <div className='chat-list'>{chatList}</div>
            <form onSubmit={(event) => handleSubmit(event, chat)}>
                <div>
                    <input type='text' name='chatInput' onChange={handleChange} value={chat} />
                </div>
                <input type='submit' value='의견 보내기' />
            </form>
        </div>
    );
}

export default CreateReadChat;