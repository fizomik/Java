/*package sample;

public class Thread_Pool {
    private Thread[] Thrd_pool;
    private static Thread_Pool pool=null;
    private int thread_cnt;

    private Thread_Pool()
    {
        Thrd_pool=new Thread[5];
        thread_cnt=0;
    }

    public static Thread_Pool getInstance()
    {
        if(pool==null)
            synchronized (Thread_Pool.class) {
                if(pool==null)
                    pool=new Thread_Pool();
            }
        return pool;
    }


    public Thread getThread(NetworkConnection t)
    {
        if(thread_cnt<5)
        {
            Thrd_pool[thread_cnt]=new ConnectionThread();;
            Thread temp=Thrd_pool[thread_cnt];
            thread_cnt++;
            return temp;

        }
        return null;

    }

}
*/