package javacesi;

/**
 * Created by Amanite on 03/10/2016.
 */
public interface ICrud {

    void Create(int id);
    <T> void Read(T object) throws AlsCustomException;
    <T> void Update(T object) throws AlsCustomException;
    void Delete(int id) throws AlsCustomException;
}
