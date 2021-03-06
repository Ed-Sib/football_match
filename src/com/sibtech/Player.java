package com.sibtech;

import java.util.Random;

public class Player {
    String playerName, playerTeam;
    int goalsScored = 0;
    Random random = new Random();
    //TODO add tracking of cards, fouls etc.
    Boolean yellowCard = false;
    int yellowCardCount = 0;
    Boolean redCard = false;
    int redCardCount = 0;

    public Player (String teamName) {
        playerName = GeneratePlayerName();
        playerTeam = teamName;
        yellowCard = false;
        redCard = false;
    }

    public void PlayerReset() {
        yellowCard = false;
        redCard = false;
    }

    public int PlayerGoal () {
        goalsScored++;
        return goalsScored;
    }

    public void PlayerYellowCard() {
        yellowCardCount++;
        if (yellowCard) {
            PlayerRedCard();
        } else {
            yellowCard = true;
        }
    }

    public void PlayerRedCard() {
        redCardCount++;
        redCard = true;
    }

    private String GeneratePlayerName() {
        String[] firstNames = {"JAMES","JOHN","ROBERT","MICHAEL","WILLIAM","DAVID","RICHARD","CHARLES","JOSEPH","THOMAS"
                ,"CHRISTOPHER","DANIEL","PAUL","MARK","DONALD","GEORGE","KENNETH","STEVEN","EDWARD","BRIAN","RONALD"
                ,"ANTHONY","KEVIN","JASON","MATTHEW","GARY","TIMOTHY","JOSE","LARRY","JEFFREY","FRANK","SCOTT","ERIC"
                ,"STEPHEN","ANDREW","RAYMOND","GREGORY","JOSHUA","JERRY","DENNIS","WALTER","PATRICK","PETER","HAROLD"
                ,"DOUGLAS","HENRY","CARL","ARTHUR","RYAN","ROGER","JOE","JUAN","JACK","ALBERT","JONATHAN","JUSTIN"
                ,"TERRY","GERALD","KEITH","SAMUEL","WILLIE","RALPH","LAWRENCE","NICHOLAS","ROY","BENJAMIN","BRUCE"
                ,"BRANDON","ADAM","HARRY","FRED","WAYNE","BILLY","STEVE","LOUIS","JEREMY","AARON","RANDY","HOWARD"
                ,"EUGENE","CARLOS","RUSSELL","BOBBY","VICTOR","MARTIN","ERNEST","PHILLIP","TODD","JESSE","CRAIG","ALAN"
                ,"SHAWN","CLARENCE","SEAN","PHILIP","CHRIS","JOHNNY","EARL","JIMMY","ANTONIO","DANNY","BRYAN","TONY"
                ,"LUIS","MIKE","STANLEY","LEONARD","NATHAN","DALE","MANUEL","RODNEY","CURTIS","NORMAN","ALLEN","MARVIN"
                ,"VINCENT","GLENN","JEFFERY","TRAVIS","JEFF","CHAD","JACOB","LEE","MELVIN","ALFRED","KYLE","FRANCIS"
                ,"BRADLEY","JESUS","HERBERT","FREDERICK","RAY","JOEL","EDWIN","DON","EDDIE","RICKY","TROY","RANDALL"
                ,"BARRY","ALEXANDER","BERNARD","MARIO","LEROY","FRANCISCO","MARCUS","MICHEAL","THEODORE","CLIFFORD"
                ,"MIGUEL","OSCAR","JAY","JIM","TOM","CALVIN","ALEX","JON","RONNIE","BILL","LLOYD","TOMMY","LEON","DEREK"
                ,"WARREN","DARRELL","JEROME","FLOYD","LEO","ALVIN","TIM","WESLEY","GORDON","DEAN","GREG","JORGE"
                ,"DUSTIN","PEDRO","DERRICK","DAN","LEWIS","ZACHARY","COREY","HERMAN","MAURICE","VERNON","ROBERTO"
                ,"CLYDE","GLEN","HECTOR","SHANE","RICARDO","SAM","RICK","LESTER","BRENT","RAMON","CHARLIE","TYLER"
                ,"GILBERT","GENE","MARC","REGINALD","RUBEN","BRETT","ANGEL","NATHANIEL","RAFAEL","LESLIE","EDGAR"
                ,"MILTON","RAUL","BEN","CHESTER","CECIL","DUANE","FRANKLIN","ANDRE","ELMER","BRAD","GABRIEL","RON"
                ,"MITCHELL","ROLAND","ARNOLD","HARVEY","JARED","ADRIAN","KARL","CORY","CLAUDE","ERIK","DARRYL","JAMIE"
                ,"NEIL","JESSIE","CHRISTIAN","JAVIER","FERNANDO","CLINTON","TED","MATHEW","TYRONE","DARREN","LONNIE"
                ,"LANCE","CODY","JULIO","KELLY","KURT","ALLAN","NELSON","GUY","CLAYTON","HUGH","MAX","DWAYNE","DWIGHT"
                ,"ARMANDO","FELIX","JIMMIE","EVERETT","JORDAN","IAN","WALLACE","KEN","BOB","JAIME","CASEY","ALFREDO"
                ,"ALBERTO","DAVE","IVAN","JOHNNIE","SIDNEY","BYRON","JULIAN","ISAAC","MORRIS","CLIFTON","WILLARD"
                ,"DARYL","ROSS","VIRGIL","ANDY","MARSHALL","SALVADOR","PERRY","KIRK","SERGIO","MARION","TRACY","SETH"
                ,"KENT","TERRANCE","RENE","EDUARDO","TERRENCE","ENRIQUE","FREDDIE","WADE"};
        String[] lastNames = {"SMITH","JONES","TAYLOR","WILLIAMS","BROWN","DAVIES","EVANS","WILSON","THOMAS","ROBERTS"
                ,"JOHNSON","LEWIS","WALKER","ROBINSON","WOOD","THOMPSON","WHITE","WATSON","JACKSON","WRIGHT","GREEN"
                ,"HARRIS","COOPER","KING","LEE","MARTIN","CLARKE","JAMES","MORGAN","HUGHES","EDWARDS","HILL","MOORE"
                ,"CLARK","HARRISON","SCOTT","YOUNG","MORRIS","HALL","WARD","TURNER","CARTER","PHILLIPS","MITCHELL"
                ,"PATEL","ADAMS","CAMPBELL","ANDERSON","ALLEN","COOK","BAILEY","PARKER","MILLER","DAVIS","MURPHY"
                ,"PRICE","BELL","BAKER","GRIFFITHS","KELLY","SIMPSON","MARSHALL","COLLINS","BENNETT","COX","RICHARDSON"
                ,"FOX","GRAY","ROSE","CHAPMAN","HUNT","ROBERTSON","SHAW","REYNOLDS","LLOYD","ELLIS","RICHARDS"
                ,"RUSSELL","WILKINSON","KHAN","GRAHAM","STEWART","REID","MURRAY","POWELL","PALMER","HOLMES","ROGERS"
                ,"STEVENS","WALSH","HUNTER","THOMSON","MATTHEWS","ROSS","OWEN","MASON","KNIGHT","KENNEDY","BUTLER"
                ,"SAUNDERS","COLE","PEARCE","DEAN","FOSTER","HARVEY","HUDSON","GIBSON","MILLS","BERRY","BARNES"
                ,"PEARSON","KAUR","BOOTH","DIXON","GRANT","GORDON","LANE","HARPER","ALI","HART","MCDONALD","BROOKS"
                ,"RYAN","CARR","MACDONALD","HAMILTON","JOHNSTON","WEST","GILL","DAWSON","ARMSTRONG","GARDNER","STONE"
                ,"ANDREWS","WILLIAMSON","BARKER","GEORGE","FISHER","CUNNINGHAM","WATTS","WEBB","LAWRENCE","BRADLEY"
                ,"JENKINS","WELLS","CHAMBERS","SPENCER","POOLE","ATKINSON","LAWSON","LAWSON","DAY","WOODS","REES"
                ,"FRASER","BLACK","FLETCHER","HUSSAIN","WILLIS","MARSH","AHMED","DOYLE","LOWE","BURNS","HOPKINS"
                ,"NICHOLSON","PARRY","NEWMAN","JORDAN","HENDERSON","HOWARD","BARRETT","BURTON","RILEY","PORTER","BYRNE"
                ,"HOUGHTON","JOHN","PERRY","BAXTER","BALL","MCCARTHY","ELLIOTT","BURKE","GALLAGHER","DUNCAN","COOKE"
                ,"AUSTIN","READ","WALLACE","HAWKINS","HAYES","FRANCIS","SUTTON","DAVIDSON","SHARP","HOLLAND","MOSS"
                ,"MAY","BATES","MOORRISON","BOB","OLIVER","KEMP","PAGE","ARNOLD","SHAH","STEVENSON","FORD","POTTER"
                ,"FLYNN","WARREN","KENT","ALEXANDER","FIELD","FREEMAN","BEGUM","RHODES","O'NEILL","MIDDLETON","PAYNE"
                ,"STEPHENSON","PRITCHARD","GREGORY","BOND","WEBSTER","DUNN","DONNELLY","LUCAS","LONG","JARVIS","CROSS"
                ,"STEPHENS","REED","COLEMAN","NICHOLLS","BULL","BARTLETT","O'BRIEN","CURTIS","BIRD","PATTERSON","TUCKER"
                ,"BRYANT","LYNCH","MACKENZIE","FERGUSON","CAMERON","LOPEZ","HAYNES","BOLTON","HARDY","HEATH","DAVEY"
                ,"RICE","JACOBS","PARSONS","ASHTON","ROBSON","FRENCH","FARRELL","WALTON","GILBERT","MCINTYRE","NEWTON"
                ,"NORMAN","HIGGINS","HODGSON","SUTHERLAND","KAY","BISHOP","BURGESS","SIMMONS","HUTCHINSON","MORAN"
                ,"FROST","SHARMA","SLATER","GREENWOOD","KIRK","FERNANDEZ","GARCIA","ATKINS","DANIEL","BEATTIE","MAXWELL"
                ,"TODD","CHARLES","PAUL","CRAWFORD","O'CONNOR","PARK","FORREST","LOVE","ROWLAND","CONNOLLY","SHEPPARD"
                ,"HARDING","BANKS","ROWE","HUMPHREYS"};
        String firstName = firstNames[random.nextInt(300)];
        String lastName = lastNames[random.nextInt(300)];
        String fullName = firstName + " " + lastName;
        return fullName;
    }
}
