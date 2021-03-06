package sample.Server.Model.ServerFactory;

import sample.Data.*;
import sample.Server.Model.Aim.AimFactory;
import sample.Server.Model.EnterToNumber.EnterToNumberFactory;
import sample.Server.Model.GameOptions.GameOptionsFactory;
import sample.Server.Model.Meteor.MeteorFactory;
import sample.Server.Model.ModelFactory;
import sample.Server.Model.MyFunction.MyFunctionFactory;
import sample.Server.Model.MyImage.MyImageFactory;
import sample.Server.Model.Player.PlayerAimFactory;
import sample.Server.Model.Player.PlayerFactory;
import sample.Server.Model.Projectile.ProjectileFactory;
import sample.Server.Model.Rectangle.RectangleFactory;
import sample.Server.Model.Sprite.SpriteFactory;
import sample.Server.Model.TextToObject.TextToObjectFactory;
import sample.Server.Model.UserConnect.UserConnectFactory;
import sample.Server.Model.Vector.VectorFactory;
import sample.Server.Model.Vector.VectorPositionFactory;
import sample.Server.Model.Vector.VectorVelocityFactory;

public class ServerFactory{

    public static Object ClassFactory(String ClassName){

        switch (ClassName) {
            case "IVecVel" -> {
                return new VectorVelocityFactory();
            }
            case "IVecPos" -> {
                return new VectorPositionFactory();
            }
            case "IModel" -> {
                return new ModelFactory();
            }
            case "IProjectile" -> {
                return new ProjectileFactory();
            }
            case "IPlayer" -> {
                return new PlayerFactory();
            }
            case "IMeteor" -> {
                return new MeteorFactory();
            }
            case "IGameOptions" -> {
                return new GameOptionsFactory();
            }
            case "IUserConnect" -> {
                return new UserConnectFactory();
            }
            case "IEnterToNumber" -> {
                return new EnterToNumberFactory();
            }
            case "IGameData" -> {
                return new GameDataFactory();
            }
            case "IMyFunction" -> {
                return new MyFunctionFactory();
            }
            case "IPlayerAim" -> {
                return new PlayerAimFactory();
            }
            case "IAim" -> {
                return new AimFactory();
            }
            case "ITextToObject" -> {
                return new TextToObjectFactory();
            }
            case "IMyImage" -> {
                return new MyImageFactory();
            }
            case "IRectangle" -> {
                return new RectangleFactory();
            }
            case "ISprite" -> {
                return new SpriteFactory();
            }
            case "IVector" -> {
                return new VectorFactory();
            }
            default -> {
                return null;
            }
        }
    }

    /*
    public static IVecVel VecVelCreateInstance() {
        return new VecVel();
    }

    public static IVecVel VecVelCreateInstance(double x, double y) {
        return new VecVel(x,y);
    }

    public static IVecPos VecPosCreateInstance() {
        return new VecPos();
    }

    public static IVecPos VecPosCreateInstance(double x, double y) {
        return new VecPos(x,y);
    }

    public static IModel ModelCreateInstance(){
        return new Model();
    }

    public static IEnterToNumberData EnterToNumberDataCreateInstance(double PosX, double PosY, double Size, ArrayList<IImageDate> FrameNumber){
        return new GameData.EnterToNumberData(PosX,PosY,Size,FrameNumber);
    }

    public static IAimData AimDataCreateInstance(double PosX, double PosY, double rotation,double ImageDataWidth, double ImageDataHeight, String file){
        return new GameData.AimData(PosX,  PosY,  rotation, ImageDataWidth,  ImageDataHeight,  file);
    }

    public static IProjectileData ProjectileDataCreateInstance(double PosX, double PosY, double rotation,double ImageDataWidth, double ImageDataHeight, String file){
        return new GameData.ProjectileData(PosX,  PosY,  rotation, ImageDataWidth,  ImageDataHeight,  file);
    }

    public static ITextData TextDataCreateInstance(double x, double y, double Width, double Height,int TextLength,
                                                   ArrayList<IImageDate> FrameImage, ArrayList<IImageDate> FrameNumber,
                                                   ArrayList<ArrayList<IMyImage>> FrameText){
        return new GameData.TextData(x,y,Width,Height,TextLength,FrameImage,FrameNumber, FrameText);
    }

    public static IMeteorData MeteorDataCreateInstance(double PosX, double PosY, double rotation,double ImageDataWidth, double ImageDataHeight, String file, ITextData Text){
        return new GameData.MeteorData(PosX,  PosY,  rotation, ImageDataWidth,  ImageDataHeight,  file,Text);
    }

    public static IProjectile ProjectileCreateInstance(IPlayer Player, char Letter, double BoxHeight, double BoxWidth, IMeteor meteor){
        return new Projectile(Player,Letter,BoxHeight,BoxWidth,meteor);
    }

    public static IPlayer PlayerCreateInstance(double Size, double WindowSizeX, double WindowSizeY){
        return new Player(Size,WindowSizeX,WindowSizeY);
    }

    public static IMeteor MeteorCreateInstance(double BoxHeight, double BoxWidth, int ID, int speed){
        return new Meteor(BoxHeight,BoxWidth,ID,speed);
    }

    public static IGameOptions GameOptionsCreateInstance(int Difficulty, int MeteorsCount, double GamePanelSizeX, double GamePanelSizeY){
        return new GameOptions(Difficulty, MeteorsCount, GamePanelSizeX, GamePanelSizeY);
    }

    public static IUserConnect UserConnectCreateInstance(String Name, Socket User, IModel GameModel){
        return new UserConnect(Name, User, GameModel);
    }

    public static ISpriteData SpriteDataCreateInstance(double PosX, double PosY, double rotation,double ImageDataWidth, double ImageDataHeight, String file){
        return new GameData.SpriteData( PosX,  PosY,  rotation, ImageDataWidth,  ImageDataHeight,  file);
    }

    public static IUserData UserDataCreateInstance(String UserName, ArrayList<String> KeyList){
        return new UserData(UserName,KeyList);
    }

    public static IUserData UserDataCreateInstance(){
        return new UserData();
    }

    public static IEnterToNumber EnterToNumberCreateInstance(double Width, double Height,double PosX, double PosY, double ImageWidth, double ImageHeight){
        return new EnterToNumber( Width,  Height, PosX,  PosY,  ImageWidth,  ImageHeight);
    }

    public static IGameData GameDataCreateInstance(int UserScore, java.util.ArrayList<ISpriteData> PlayersGun, boolean GameProcess, ArrayList<IMeteorData> MeteorList, ArrayList<IProjectileData> ProjectileList, ArrayList<IAimData> PlayersAim, IEnterToNumberData enterToNumberData){
        return new GameData(UserScore, PlayersGun, GameProcess, MeteorList, ProjectileList, PlayersAim, enterToNumberData);
    }

    public static IGameData GameDataCreateInstance(){
        return new GameData();
    }

    public static IMyFunction MyFunctionCreateInstance(){
        return new MyFunction();
    }

    public static IPlayerAim PlayerAimCreateInstance(double BoxWidth, double BoxHeight, double RestrictedArea){
        return new PlayerAim(BoxWidth,BoxHeight,RestrictedArea);
    }

    public static IAim AimCreateInstance(double BoxWidth, double BoxHeight, double RestrictedArea){
        return new Aim(BoxWidth,BoxHeight,RestrictedArea);
    }

    public static ITextToObject TextToObjectCreateInstance(double x, double y, double Width, double Height, String Text, int ID) {
        return new TextToObject(x,y,Width,Height,Text,ID);
    }

    public static IMyImage MyImageCreateInstance(String fileImageName, double Width, double Height, String ImageName, boolean Type) {
        return new MyImage(fileImageName,Width,Height,ImageName,Type);
    }

    public static IImageDate ImageDateCreateInstance(String fileImageName, double sizeImage) {
        return new GameData.ImageDate(fileImageName,sizeImage);
    }

    public static IImageDate ImageDateCreateInstance(String fileImageName, double Width, double Height) {
        return new GameData.ImageDate(fileImageName,Width,Height);

    }

    public static IImageDate ImageDateCreateInstance(String fileImageName) {
        return new GameData.ImageDate(fileImageName);
    }

    public static IRectangle RectangleCreateInstance() {
        return new Rectangle();
    }

    public static IRectangle RectangleCreateInstance(double x, double y, double width, double height){
        return new Rectangle(x,y,width,height);
    }

    public static ISprite SpriteCreateInstance(){
        return new Sprite();
    }

    public static ISprite SpriteCreateInstance(String fileImageName, double sizeImage) {
        return new Sprite(fileImageName,sizeImage);
    }

    public static ISprite SpriteCreateInstance(String fileImageName) {
        return new Sprite(fileImageName);
    }

    public static ISprite SpriteCreateInstance(String fileImageName, double Width, double Height) {
        return new Sprite(fileImageName, Width, Height);
    }

    public static IVector VectorCreateInstance() {
        return new Vector();
    }

    public static IVector VectorCreateInstance(double x, double y) {
        return new Vector(x,y);
    }

     */
}
