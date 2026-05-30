-- Fix ORA-02290 CHK_VEH_HORAS: cambiar DEFAULT SYSTIMESTAMP a CURRENT_TIMESTAMP
-- para que hora_entrada en VEHICULOS_VISITA se almacene en zona horaria de sesion (America/Bogota)
-- y la comparacion hora_salida > hora_entrada del trigger TRG_ACCESO_SALIDA funcione correctamente.

ALTER TABLE VEHICULOS_VISITA MODIFY (hora_entrada DEFAULT CURRENT_TIMESTAMP);
ALTER TABLE REGISTROS_ACCESO MODIFY (hora_entrada DEFAULT CURRENT_TIMESTAMP);
ALTER TABLE REGISTROS_ACCESO MODIFY (fecha_registro DEFAULT CURRENT_TIMESTAMP);

-- Verificar cambios
SELECT table_name, column_name, data_default, data_type
FROM   user_tab_columns
WHERE  table_name IN ('VEHICULOS_VISITA', 'REGISTROS_ACCESO')
  AND  column_name IN ('HORA_ENTRADA', 'FECHA_REGISTRO')
ORDER BY table_name, column_name;
