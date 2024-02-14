package ru.proskurnin.core;

public class App 
{
    public static void main(String[] args) {
        // Создаем пул потоков с емкостью 3
        MyPool threadPool = new MyPool(3);

        // Добавляем задачи в пул потоков
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            Runnable task = () -> {
                System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Эмулируем выполнение задачи
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            threadPool.execute(task);
        }

        // Ждем некоторое время, чтобы убедиться, что задачи выполняются
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Завершаем пул потоков после выполнения всех задач
        threadPool.shutdown();
    }
}
