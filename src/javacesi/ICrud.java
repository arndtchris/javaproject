package javacesi;

/**
 * Created by Amanite on 03/10/2016.
 */
public interface ICrud {

    void Create();
    <T> void Read() throws AlsCustomException;
    <T> void Update() throws AlsCustomException;
    void Delete() throws AlsCustomException;
}
