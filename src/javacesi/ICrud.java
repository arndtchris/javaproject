package javacesi;

/**
 * Created by Amanite on 03/10/2016.
 */
public interface ICrud {

    void Create(int id);
    <T> void Read(T object);
    <T> void Update(T object);
    void Delete(int id);
}
