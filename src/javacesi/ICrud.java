package javacesi;

/**
 * Created by Amanite on 03/10/2016.
 */
public interface ICrud {

    void Create();
    void Read() throws AlsCustomException;
    void Update() throws AlsCustomException;
    void Delete() throws AlsCustomException;
}
