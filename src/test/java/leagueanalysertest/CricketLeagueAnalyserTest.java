package leagueanalysertest;

import com.google.gson.Gson;
import cricketleagueanalyser.CricketLeagueAnalyser;
import opencsv.CSVBuilderException;
import org.junit.Assert;
import org.junit.Test;
import pojo.IplBatsmanDTO;
import pojo.IplBowlerDTO;

public class CricketLeagueAnalyserTest {
    public static final String CORRECTED_BATTING_CSV = "./src/test/resources/IPL2019FactSheetMostRun.csv";
    public static final String CORRECTED_BOWLING_CSV = "./src/test/resources/IPL2019FactSheetMostWkt.csv";
    public static final String CSV_WITH_DELIMITER_ERROR = "./src/test/resources/CsvWithDelimiterErr.csv";
    public static final String CSV_WITH_HEADER_ERROR = "./src/test/resources/CsvWithHeaderErr.csv";
    public static final String INCORRECT_FILE = "./src/test/resources/IPLData.csv";
    CricketLeagueAnalyser leagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.PlayerType.BOWLER);
    @Test
    public void givenCricketLeagueCsvFileIfHasCorrectNumberOfRecordsShouldReturnNumberOfRecord() {
        try {
            int numberOfRecords = leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
            Assert.assertEquals(99, numberOfRecords);
        } catch (CSVBuilderException e) {
               e.printStackTrace();
            }
    }
    @Test
    public void givenCricketLeagueCsvFileIfHasDelimiterErrorsInItShouldThrowException() {
        try {
              leagueAnalyser.loadIplData(CSV_WITH_DELIMITER_ERROR);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }
    @Test
    public void givenCricketLeagueCsvFileIfHasHeaderErrorsInItShouldThrowException() {
        try {
            leagueAnalyser.loadIplData(CSV_WITH_HEADER_ERROR);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }
    @Test
    public void givenWrongFileAsInputToTheFileLoaderShouldThrowException() {
        try {
            leagueAnalyser.loadIplData(INCORRECT_FILE);
        } catch (CSVBuilderException e) {
            Assert.assertEquals(CSVBuilderException.ExceptionType.IPL_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenCricketLeagueCsvFileShouldReturnTopBattingAverageListWithCorrectFirstPosition() {
        try {
            leagueAnalyser.loadIplData(CORRECTED_BATTING_CSV);
            String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnBattingAverage();
            IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage,IplBatsmanDTO[].class);
            Assert.assertEquals("MS Dhoni",batsmenArray[0].playerName);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenCricketLeagueCsvFileShouldReturnTopBattingAverageListWithCorrectSecondPosition() {
        try {
            leagueAnalyser.loadIplData(CORRECTED_BATTING_CSV);
            String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnBattingAverage();
            IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
            Assert.assertEquals("David Warner",batsmenArray[1].playerName);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenCricketLeagueCsvFileShouldReturnTopBattingStrikeRateListWithCorrectFirstPosition() {
        try {
            leagueAnalyser.loadIplData(CORRECTED_BATTING_CSV);
            String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnStrikeRate();
            IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage,IplBatsmanDTO[].class);
            Assert.assertEquals("Ishant Sharma",batsmenArray[0].playerName);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenCricketLeagueCsvFileShouldReturnTopBattingStrikeRateListWithCorrectSecondPosition() {
        try {
            leagueAnalyser.loadIplData(CORRECTED_BATTING_CSV);
            String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnStrikeRate();
            IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
            Assert.assertEquals("Andre Russell", batsmenArray[1].playerName);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        @Test
        public void givenCricketLeagueCsvFileShouldReturnTopBattingStrikeRateListWithCorrectFirstPosition () {
            try {
                leagueAnalyser.loadIplData(CORRECTED_BATTING_CSV);
                String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnStrikeRate();
                IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                Assert.assertEquals("Ishant Sharma", batsmenArray[0].playerName);
            } catch (CSVBuilderException e) {
                e.printStackTrace();
            }
        }
        @Test
        public void givenCricketLeagueCsvFileShouldReturnTopBattingStrikeRateListWithCorrectSecondPosition () {
            try {
                leagueAnalyser.loadIplData(CORRECTED_BATTING_CSV);
                String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnStrikeRate();
                IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                Assert.assertEquals("Andre Russell", batsmenArray[1].playerName);
            } catch (CSVBuilderException e) {
                e.printStackTrace();
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnWhoHadBestStrikeRateWithSixAtFirstPosition () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BATTING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnStrikeRateWithSix();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("Ishant Sharma", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnWhoHadBestStrikeRateWithFourAtFirstPosition () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BATTING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnStrikeRateWithFours();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("Ishant Sharma", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnWhoHadBestStrikeRateWithSixAtFirstPosition () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BATTING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnStrikeRateWithSix();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("Ishant Sharma", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnWhoHadBestStrikeRateWithFourAtFirstPosition () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BATTING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnStrikeRateWithFours();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("Ishant Sharma", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnWhoHadMaxRunWithBestAverageAtFirstPosition () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BATTING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnRunsWithAverage();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("David Warner", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnWhoHadMaxRunWithBestAverageAtSecondPosition () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BATTING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnRunsWithAverage();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("KL Rahul", batsmenArray[1].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnTopBowlingAveragePlayerListAtFirstPosition () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnBowlingAverage();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("Krishnappa Gowtham", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnTopBowlingAveragePlayerListAtSecondPosition () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnBowlingAverage();
                    IplBowlerDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBowlerDTO[].class);
                    Assert.assertEquals("Tim Southee", batsmenArray[1].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnTopStrikingRateOfBowlerAtFirstPosition () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnStrikeRate();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("Krishnappa Gowtham", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnSecondTopStrikingRateOfBowlerAtSecondPosition () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnStrikeRate();
                    IplBowlerDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBowlerDTO[].class);
                    Assert.assertEquals("Prasidh Krishna", batsmenArray[1].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnTopEconomyRateOfBowlerAtFirstPosition () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnEconomyRate();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("Ben Cutting", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnSecondTTopEconomyRateOfBowlerAtSecondPosition () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnEconomyRate();
                    IplBowlerDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBowlerDTO[].class);
                    Assert.assertEquals("Tim Southee", batsmenArray[1].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnWhoHadBestStrikeRateWithFiveWkt () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnStrikeRateWithFiveWkt();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("Krishnappa Gowtham", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnWhoHadBestStrikeRateWithFourWkt () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnStrikeRateWithFouWkt();
                    IplBowlerDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBowlerDTO[].class);
                    Assert.assertEquals("Krishnappa Gowtham", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnWhoHadGreatBowlingAverageWithBestStrikeRate () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnBowlingAverageWithStrikeRate();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("Krishnappa Gowtham", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnWhoTookMaxWktWithBestBowlingAverage () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnMaxWktWithBowlingAverage();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("Imran Tahir", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnWhoHadTheBestBattingAndBowlingAverage () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnBattingAndBowlingAverage();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("Krishnappa Gowtham", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void givenCricketLeagueCsvFileShouldReturnWhoIsTheBestAllRounders () {
                try {
                    leagueAnalyser.loadIplData(CORRECTED_BOWLING_CSV);
                    String sortBasedOnBattingAverage = leagueAnalyser.sortBasedOnRunsAndWickets();
                    IplBatsmanDTO[] batsmenArray = new Gson().fromJson(sortBasedOnBattingAverage, IplBatsmanDTO[].class);
                    Assert.assertEquals("Imran Tahir", batsmenArray[0].playerName);
                } catch (CSVBuilderException e) {
                    e.printStackTrace();
                }
            }
        }
    }