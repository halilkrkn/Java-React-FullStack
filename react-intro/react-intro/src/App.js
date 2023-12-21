import React, { useState } from 'react';
import './App.css';

function App() {
    const [todos, setTodos] = useState([]);
    const [newTodo, setNewTodo] = useState('');

    const addTodo = () => {
        if (newTodo.trim() !== '') {
            setTodos((prevTodos) => [
                ...prevTodos,
                { id: Date.now(), text: newTodo, completed: false },
            ]);
            setNewTodo('');
        }
    };

    const toggleTodo = (id) => {
        setTodos((prevTodos) =>
            prevTodos.map((todo) =>
                todo.id === id ? { ...todo, completed: !todo.completed } : todo
            )
        );
    };

    const deleteTodo = (id) => {
        setTodos((prevTodos) => prevTodos.filter((todo) => todo.id !== id));
    };

    return (
        <div className="todo-app">
            <h1 className="app-title">Yapılacaklar</h1>
            <div className="todo-input">
                <input
                    type="text"
                    className="todo-input-field"
                    placeholder="Yapılacak ekleyin"
                    value={newTodo}
                    onChange={(e) => setNewTodo(e.target.value)}
                />
                <button className="todo-add-button" onClick={addTodo}>
                    Ekle
                </button>
            </div>
            <ul className="todo-list">
                {todos.map((todo) => (
                    <li key={todo.id} className="todo-item">
                        <input
                            type="checkbox"
                            className="todo-checkbox"
                            checked={todo.completed}
                            onChange={() => toggleTodo(todo.id)}
                        />
                        <span
                            className={`todo-text ${todo.completed ? 'completed' : ''}`}
                        >
              {todo.text}
            </span>
                        <button className="todo-delete-button" onClick={() => deleteTodo(todo.id)}>
                            Sil
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
