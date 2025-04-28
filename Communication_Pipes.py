import multiprocessing

def child_process(conn):
    message = "Hello from child process!"
    conn.send(message)  # Send message through pipe
    conn.close()

def parent_process():
    parent_conn, child_conn = multiprocessing.Pipe()

    process = multiprocessing.Process(target=child_process, args=(child_conn,))
    process.start()

    message = parent_conn.recv()  # Receive message from child
    print(f"Parent received: {message}")

    parent_conn.close()
    process.join()

if __name__ == "__main__":
    parent_process()
