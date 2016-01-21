package jdlv;

import logic.*;
import java.util.*;

public  class BancoVuotoAI{

private BriscolaManager manager;
private List<CartaDaGiocareJDLV> manoGiocatore;
private List<BancoJDLV> banco;
private List<CartaDaGiocareJDLV> soluzione;
public BancoVuotoAI(BriscolaManager manager){
 this .manager=manager;
 this .soluzione= new ArrayList<CartaDaGiocareJDLV>();
 this .manoGiocatore= new ArrayList<CartaDaGiocareJDLV>();
 this .banco= new ArrayList<BancoJDLV>();
}
public  void  gioca(){
List<Carta> mieCarte=manager.getG1().getMieCarte();
List<Carta> cartePrese=manager.getG1().getCartePrese();
manoGiocatore.clear();
banco.clear();
for(int i= 0 ;i<mieCarte.size();i++)
{
Carta c=mieCarte.get(i);
CartaDaGiocareJDLV cartaJDLV= new CartaDaGiocareJDLV(c.getId(),c.getSeme());
manoGiocatore.add(cartaJDLV);
}
for(int i:manager.getBanco().keySet())
{
banco.add( new BancoJDLV(manager.getBanco().get(i).getId(),manager.getBanco().get(i).getSeme()));
}
boolean solution= true ;

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation EXECUTING JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_EXECUTING=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_EXECUTING.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_EXECUTING=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_EXECUTING;

	// ---- END - startProgram ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(banco,"banco"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'banco::banco' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(banco,"banco"), 0));

	// ---- END - addInMapping ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(manoGiocatore,"manoGiocatore"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'manoGiocatore::manoGiocatore' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(manoGiocatore,"manoGiocatore"), 0));

	// ---- END - addInMapping ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'soluzione::gioco' in module EXECUTING.");

	// ---- START - prepareJDLVCall ---- 
try{

_JDLV_INVOCATION_EXECUTING=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
_JDLV_PROGRAM_EXECUTING.addText(_JDLV_PROGRAM_BUFFER_EXECUTING.toString());
_JDLV_PROGRAM_EXECUTING.getFiles().clear();
_JDLV_PROGRAM_EXECUTING.addFile("DLV/bancoVuotoDLV.txt");
_JDLV_INVOCATION_EXECUTING.setNumberOfModels(1);
_JDLV_PROGRAM_BUFFER_EXECUTING.append("");
_JDLV_INVOCATION_EXECUTING.setInputProgram(_JDLV_PROGRAM_EXECUTING);
it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_EXECUTING=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_EXECUTING);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution EXECUTING program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_EXECUTING.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_EXECUTING.getInputProgram().getCompleteText(),0)+'\n'+"Files execution: DLV/bancoVuotoDLV.txt");
_JDLV_INVOCATION_EXECUTING.run();
while(_BUFFERED_HANDLER_EXECUTING.hasMoreModels()){
it.unical.mat.wrapper.Model _temporary_JDLV_MODELEXECUTING=_BUFFERED_HANDLER_EXECUTING.nextModel();
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(soluzione, "gioco",_temporary_JDLV_MODELEXECUTING,CartaDaGiocareJDLV.class);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "soluzione " + soluzione.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(soluzione,0));
}
if(_JDLV_INVOCATION_EXECUTING.haveModel()==false){
solution= false ;
System.out.println( "Nessuna Soluzione" );
}
if(!_JDLV_INVOCATION_EXECUTING.getErrors().isEmpty()){
throw new java.lang.RuntimeException(_JDLV_INVOCATION_EXECUTING.getErrors().get(0).getText());
}
}
catch(java.lang.Throwable _JDLV_EXCEPTION_EXECUTING){
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_EXECUTING.getMessage());
}
_JDLV_PROGRAM_EXECUTING.cleanText();

	// ---- END - prepareJDLVCall ---- 
if(solution)
System.out.println( "Soluzione trovata" );
}
public List<CartaDaGiocareJDLV> getSoluzione(){
return soluzione;
}
}

