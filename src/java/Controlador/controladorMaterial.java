/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Materiales.Material;
import ModeloMaterial.ModeloMaterial;
/**
 *
 * @author David
 */
public class controladorMaterial 
{
    public boolean crarMaterial(Material m)
    {
        ModeloMaterial modeloMat = new ModeloMaterial();
        return modeloMat.registroMaterial(m);
    }
    public String getMateriales()
    {
        String html = "";
        ModeloMaterial mp = new ModeloMaterial();
        for (Material m : mp.getAllMateriales()) 
        {
            html = html+
"           <tr>\n" +
"               <td><input align=\"center\" type=\"text\" name=\"ClaveMaterial\" id=\"ClaveMaterial\" size=\"6\" readonly value="+m.getClave()+"></td>\n" +
"               <td id=\"Id-NombreMaterial\"><textarea name=\"NombreMaterial\" id=\"NombreMaterial\" rows=\"1\" readonly>"+m.getNombre()+"</textarea></td>\n" +
"               <td> <input type=\"text\" name=\"UnidadControl\" id=\"UnidadControl\" size=\"9\" readonly value="+m.getUnidadControl()+"> \n" +
"               <td> <input type=\"text\" name=\"PrecioLista\" id=\"PrecioLista\" size=\"6\" readonly value="+m.getPrecioLista()+"> </td>\n" +
"               <td> <input type=\"text\" name=\"PesoTeorico\" id=\"PesoTeorico\" size=\"5\" readonly value="+m.getPesoTeorico()+"> </td>\n" +
"               <td> "+
                     "<a href='modificarMaterial.jsp?ClaveMaterial="+m.getClave()+"'>Modificar</a>\n" +
"                     <a id=\"a-eliminar\" href=\"\">Eliminar</a>"
              + "</td>\n" +
"           </tr>";
        }
        return html;
    }
    public String getMaterial(String ClaveMaterial){
        ModeloMaterial mod = new ModeloMaterial();
        Material mat = mod.getOneMaterial(ClaveMaterial);
        String html="                    <tr>\n" +
"       <td><input align=\"center\" type=\"hidden\" name=\"ClaveMaterial\" id=\"ClaveMaterial\" value="+mat.getClave()+"></td>\n" +
"       </tr>\n" +
"        <tr>\n" +
"             <th>Nombre</th>\n" +
"                    <td> <textarea name=\"NombreMaterial\" id=\"NombreMaterial\" rows=\"1\">"+mat.getNombre()+"</textarea>> </td>\n" +
"        </tr>\n" +
"         <tr>\n" +
"                <th>Precio de Lista</th>\n" +
"         <td> <input type=\"number\" step=\"any\" name=\"PrecioLista\" id=\"Precio_Lista\" value="+mat.getPrecioLista()+"> </td>\n" +
"         </tr>\n" +
"         <tr>\n" +
"         <th>Peso Teorico</th>\n" +
"         <td> <input type=\"number\" step=\"any\" name=\"PesoTeorico\" id=\"Peso_Teorico\" value="+mat.getPesoTeorico()+"> </td>\n" +
"         </tr>"+
"         <tr>\n" +
"         <th>Unidad de Control</th>\n" +
"              <td> <select name=\"UnidadControl\" id=\"Unidad_Control\"> \n";
        
        if(mat.getUnidadControl().equals("Kilo"))
        {
            html = html + "<option value=\"1\" selected>Kilo</option>\n";
        }
        else{
            html = html + "<option value=\"1\">Kilo</option>\n";
        }
        if(mat.getUnidadControl().equals("Litro"))
        {
            html = html + "<option value=\"2\" selected>Litro</option>\n";
        }
        else{
            html = html + "<option value=\"2\">Litro</option>\n";
        }
        
        if(mat.getUnidadControl().equals("Pieza"))
        {
            html = html + "<option value=\"3\"selected>Pieza</option>\n";
        }else{
            html = html + "<option value=\"3\">Pieza</option>\n";
        }
        if (mat.getUnidadControl().equals("Metros"))
        {
            html = html + "<option value=\"4\" selected>Metros</option>\n" +
"                 </select>\n" +
"             </td>\n" +
"         </tr>\n"; ;
        }else{
            html = html + "<option value=\"4\">Metros</option>\n"+
"                 </select>\n" +
"             </td>\n" +
"         </tr>\n";
        }
        return html;
    }
    public boolean eliminarMaterial(String nombreMaterial)
    {
        ModeloMaterial mp = new ModeloMaterial();
        return mp.eliminarMaterial(nombreMaterial);
    }
    public boolean modificarMaterial(Material m)
    {
        ModeloMaterial mod = new ModeloMaterial();        
        return mod.modificarMaterial(m);
    }    
    
    public String getMaterialesConsulta(String NombreMaterial)
    {
        String html = "";
        ModeloMaterial mp = new ModeloMaterial();
        for (Material m : mp.getMaterialesConsulta(NombreMaterial)) 
        {
            html = html+
"           <tr>\n" +
"               <td><input align=\"center\" type=\"text\" name=\"ClaveMaterial\" id=\"ClaveMaterial\" size=\"6\" readonly value="+m.getClave()+"></td>\n" +
"               <td id=\"Id-NombreMaterial\"><textarea name=\"NombreMaterial\" id=\"NombreMaterial\" rows=\"1\" readonly>"+m.getNombre()+"</textarea></td>\n" +
"               <td> <input type=\"text\" name=\"UnidadControl\" id=\"UnidadControl\" size=\"9\" readonly value="+m.getUnidadControl()+"> \n" +
"               <td> <input type=\"text\" name=\"PrecioLista\" id=\"PrecioLista\" size=\"6\" readonly value="+m.getPrecioLista()+"> </td>\n" +
"               <td> <input type=\"text\" name=\"PesoTeorico\" id=\"PesoTeorico\" size=\"5\" readonly value="+m.getPesoTeorico()+"> </td>\n" +
"               <td> "+
                     "<a href='modificarMaterial.jsp?ClaveMaterial="+m.getClave()+"'>Modificar</a>\n" +
"                     <a id=\"a-eliminar\" href=\"\">Eliminar</a>"
              + "</td>\n" +
"           </tr>";
        }
        return html;
    }
    public String getMatParaCotizacion(String NombreMaterial, boolean borrarAllMat)
    {
        String html = "";
        ModeloMaterial mp = new ModeloMaterial();
        for (Material m : (borrarAllMat)? mp.getMaterialesConsulta(NombreMaterial): mp.getAllMateriales()) 
        {
            html = html+
"           <tr>\n" +
"               <td id=\"td-ClaveMaterial\"><input align=\"center\" type=\"text\" "
                    + "name=\"ClaveMaterial\" id=\"ClaveMaterial\" size=\"6\" "
                    + "readonly value="+m.getClave()+"></td>\n" +
"               <td id=\"td-NombreMaterial\"><textarea name=\"NombreMaterial\" "
                    + "id=\"NombreMaterial\" rows=\"1\" readonly>"+m.getNombre()
                    +"</textarea></td>\n" +
"               <td id=\"td-UnidadControl\" hidden> <input type=\"text\" "
                    + "name=\"UnidadControl\" id=\"UnidadControl\" size=\"9\" "
                    + "readonly value="+m.getUnidadControl()+"> \n" +
"               <td id=\"td-PrecioLista\" hidden> <input type=\"text\" "
                    + "name=\"PrecioLista\" id=\"PrecioLista\" size=\"6\" "
                    + "readonly value="+m.getPrecioLista()+"> </td>\n" +
"               <td id=\"td-PesoTeorico\" hidden> <input type=\"text\" "
                    + "name=\"PesoTeorico\" id=\"PesoTeorico\" size=\"5\" "
                    + "readonly value="+m.getPesoTeorico()+"> </td>\n" +
"               <td id=\"td-Cantidad\"> <input type=\"number\" "
                    + "name=\"Cantidad\" id=\"Cantidad\" value=\"1\" size=\"3\" min=\"0\" max=\"1000\"></td>\n" +
"               <td> <a id=\"a-agregar\" href=\"\">Agregar</a> </td>\n"+
"           </tr>";
        }
        return html;
    }
}
